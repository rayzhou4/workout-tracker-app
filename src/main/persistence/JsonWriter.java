package persistence;

import model.WorkoutHistory;
import org.json.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonWriter {
    private static final int TAB_SPACE = 4;
    private PrintWriter writer;
    private String dest;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String dest) {
        this.dest = dest;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(dest));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(WorkoutHistory workoutHistory) {
        JSONObject json = workoutHistory.toJson();
        saveToFile(json.toString(TAB_SPACE));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
