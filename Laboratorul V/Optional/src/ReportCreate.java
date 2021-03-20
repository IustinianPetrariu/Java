import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCreate {

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration(new Version("2.3.31"));
        /// we define some items that belongs to the catalog
        Item song1 = new Song("All of me!", "E:\\FII\\Semestrul III\\Engleza\\AlinaEremia.mp3");
        Item book1 = new Book("Homosapiens", "E:\\FII\\Semestrul III\\Engleza\\Taboo.pdf");

        Catalog myCatalog = new Catalog();
        myCatalog.setName("Catalog 1");
        myCatalog.add(song1);
        myCatalog.add(book1);

        cfg.setClassForTemplateLoading(ReportCreate.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("web.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("title", "Your catalog is : ");
        /// we have to provide a getter from object catalog
        //// in order for template to acces the data, or to store the data in public field
        //// which is not recommended
        templateData.put("catalogs", myCatalog.getList());

        try (FileWriter out = new FileWriter("output.html")) {

            template.process(templateData, out);
            //System.out.println(out.getBuffer().toString());

            out.flush();
        }
    }
}

