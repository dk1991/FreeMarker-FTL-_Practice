package ru.kanaev.freemarker;

import freemarker.core.ParseException;
import freemarker.template.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FTLHelloWorld {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        try {
            Template template = cfg.getTemplate("src/main/helloworld.ftl");

            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message","Hello man!");

            List<String> countries = new ArrayList<String>();
            countries.add("Russia");
            countries.add("France");
            countries.add("Belgium");
            countries.add("USA");

            data.put("countries",countries);

            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            Writer file = new FileWriter(new File("C:\\boot\\ftl_hello.txt"));
            template.process(data,file);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
