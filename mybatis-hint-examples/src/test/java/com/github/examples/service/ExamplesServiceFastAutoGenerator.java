package com.github.examples.service;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 代码生成
 */
public class ExamplesServiceFastAutoGenerator {

    public static void main(String[] args) {
       FastAutoGenerator.create("jdbc:mysql://localhost:3306/dev_test", "root", "toot")
                .globalConfig(builder -> {
                    builder
                            // 设置作者
                            .author("wzq")
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 覆盖已生成文件
//                            .fileOverride()
                            // 指定输出目录
                            .outputDir("mybatis-hint-examples" + "\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder
                            // 设置父包名
                            .parent("com.github.hint.examples.service")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .entity("dao.entity")
                            .mapper("dao.mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "mybatis-hint-examples" + "\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder
                            // 设置需要生成的表名
                            .addInclude("test_user")
                            // 设置过滤表前缀
                            .addTablePrefix("test_")
                            // 开启Lombok
                            .entityBuilder().enableLombok()
                            // ID自增
                            .entityBuilder().idType(IdType.AUTO);
                })
                // 无需生成部分可在此配置
                .templateConfig(builder -> {
                    builder
                            // .controller(null)
                           // .service(null)
                           // .serviceImpl(null)
                            .build();
                })
                .injectionConfig(builder -> {
                    builder.beforeOutputFile((tableInfo, objectMap) -> {

                    });
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
