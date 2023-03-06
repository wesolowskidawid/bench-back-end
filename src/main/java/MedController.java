import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import objects.Med;
import utils.CalcUtil;

import java.util.*;

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

    public static void getMedByMedName(Context context) {
        for(Med m : meds) {
            if(m.getName().contains(context.pathParam("medName"))) {
                context.json(m);
                return;
            }
        }
        context.result("Not found.");
    }

    public static void calculate(Context context) throws JsonProcessingException {
        String body = context.body();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> json = mapper.readValue(body, new TypeReference<Map<String,Object>>(){});
        double weight = Double.parseDouble(json.get("weight").toString());
        Med med = meds.get(Integer.parseInt(json.get("id").toString()));

        double activeSubstance = CalcUtil.calculateActiveSubstance(weight, med.getDoseMg(), med.getDoseKg());
        double medDose = CalcUtil.calculateDose(activeSubstance, med.getPowerMg(), med.getPowerMl());
        String packageSize;
        CalcUtil util = new CalcUtil();
        if(med.getCapsuleSizeMl() == 0) {
            packageSize = util.calculatePackageSizeNoCapsules(7, 2, medDose, med.getPackageSizeMl()).toString();
        }
        else {
            packageSize = util.calculatePackageSizeCapsules(7, 2, medDose, med.getPackageSizeMl(), med.getCapsuleSizeMl()).toString();
        }

        Map<String, String> result = new HashMap<>();
        result.put("weight", String.valueOf(weight));
        result.put("activesubstance", String.valueOf(activeSubstance));
        result.put("meddose", String.valueOf(medDose));
        result.put("packagesize", packageSize);


        context.json(result).status(200);
    }
}
