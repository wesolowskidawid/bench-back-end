import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);

        app.before((ctx) -> {
            ctx.header("Access-Control-Allow-Origin", "*");
            ctx.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            ctx.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        });

        app.get("/meds", MedController::getAllMeds);
        app.get("/meds/{medName}", MedController::getMedByMedName);
        app.post("/calc", MedController::calculate);
    }

}
