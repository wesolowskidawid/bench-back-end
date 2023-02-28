import io.javalin.http.Context;
import objects.Med;

import java.util.Arrays;
import java.util.List;

public final class MedController {

    private MedController() {}

    static final List<Med> meds =
            List.of(new Med[]{
                    new Med("APAP", 40.0, 1.0, Arrays.asList(85.0, 150.0), 0, 15.0, 1.0),
                    new Med("LEVOpront", 60.0, 10.0, List.of(120.0), 0, 1.5, 1.0),
                    new Med("Pulmicort", 0.5, 1.0, Arrays.asList(10.0, 20.0), 2, 0.25, 5.0)
            });

    public static void getAllMeds(Context context) {
        context.json(meds);
    }
}
