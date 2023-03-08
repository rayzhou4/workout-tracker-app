package persistence;

import org.json.JSONObject;

// an interface that classifies a class as a writable file
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
