package com.company.commands;

import com.company.Catalog;
import com.company.Item;
import com.company.Main;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.awt.*;
import java.io.*;
import java.util.*;


public class ReportCommand extends Command{
    public void report(Catalog c) throws Exception{
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Main.class, "templates");

        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("title", "Catalog");

        input.put("systems", c.getItems());

        Template template = cfg.getTemplate("catalog.ftl");

        //writitg the ouptut of the report in the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        //writing the ouptup of teh report in a html file and open it.
        File f = new File("output.html");
        Writer fileWriter = new FileWriter(f);
        try {
            template.process(input, fileWriter);
                Desktop.getDesktop().open(f);
            }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }

    }
}
