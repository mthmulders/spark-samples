package it.mulders.spark;

import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;

public class JavaMagazineApplication
{
    public static void main( final String... args )
    {
        var controller = new GreetingController();
        var transformer = new JsonResponseTransformer();
        var templateEngine = new ThymeleafTemplateEngine();

        before( "/hello/complex", "application/json", JsonParsingFilter.forType( GreetingInput.class ) );

        get("/hello/simple", controller::simpleGreeting);
        post("/hello/complex", controller::complexGreeting, transformer);
        get("/hello/simple/:name", controller::withName);
        get("/hello/html/:name", controller::pageWithName, templateEngine::render);
        post("/hello/name", controller::updateName);
    }
}
