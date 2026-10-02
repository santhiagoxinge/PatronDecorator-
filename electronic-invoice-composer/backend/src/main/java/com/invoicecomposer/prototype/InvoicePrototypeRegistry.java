package com.invoicecomposer.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry that stores reusable invoice templates and returns cloned instances.
 */
public class InvoicePrototypeRegistry {

    private final Map<String, InvoicePrototype> prototypes = new HashMap<>();

    public void registerPrototype(String key, InvoicePrototype prototype) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("The prototype key cannot be blank");
        }
        prototypes.put(key, prototype);
    }

    public InvoicePrototype getPrototype(String key) {
        InvoicePrototype prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }
        return prototype.clone();
    }
}
