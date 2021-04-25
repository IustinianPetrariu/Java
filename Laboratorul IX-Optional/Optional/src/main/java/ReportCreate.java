import controller.MovieControllerJDBC;
import dao.MovieJDBC;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReportCreate {

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(ReportCreate.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        MovieControllerJDBC movies = new MovieControllerJDBC();
        ///create the list in order to store the movies and then print them on html
        List<MovieJDBC> listOfMovies = new ArrayList<>();
        listOfMovies = movies.getAllMovies();
        Template template = cfg.getTemplate("web.ftl");
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("title", "Your table of movies is : ");

        templateData.put("movies", listOfMovies);
        try (FileWriter out = new FileWriter("output.html")) {

            template.process(templateData, out);
            //System.out.println(out.getBuffer().toString());

            out.flush();
        }

    }
}
