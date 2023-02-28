import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);

        app.get("/meds", MedController::getAllMeds);
    }

}