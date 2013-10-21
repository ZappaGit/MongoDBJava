package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: diego
 * Date: 10/14/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                HelloWorldFreemarkerStyle.class, "/"
        );
        try {
            Template helloTemplate = configuration.getTemplate("hello.html");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "freemarker");

            helloTemplate.process(helloMap, writer);

        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
