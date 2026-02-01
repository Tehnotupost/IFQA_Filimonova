package localhostapi.filters;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

public class AllureSecurityListener implements StepLifecycleListener {
    @Override
    public void beforeStepStop(StepResult result) {
        if (result.getName() != null) {
            result.setName(mask(result.getName()));
        }
        result.getParameters().forEach(param -> {
            if (isSensitiveParam(param.getName())) {
                param.setValue("********-****-****-****-************");
            } else {
                param.setValue(mask(param.getValue()));
            }
        });
    }

    private boolean isSensitiveParam(String name) {
        String lowerName = name.toLowerCase();
        return lowerName.contains("token") ||
                lowerName.contains("auth") ||
                lowerName.contains("password");
    }

    private String mask(String text) {
        if (text == null) return null;

        return text
                .replaceAll("(\"password\"\\s*:\\s*\")[^\"]+(\")", "$1******$2")
                .replaceAll("(\"token\"\\s*:\\s*\")[^\"]+(\")", "$1******$2")
                .replaceAll("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}", "********-****-****-****-************");
    }
}
