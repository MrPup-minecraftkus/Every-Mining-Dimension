package net.mrpup.everyminingdimension.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("everyminingdimension.json");

    public boolean spawnMonsterInMiningDimensions = false;
    public boolean spawnAnimalInMiningDimensions = false;

    private static ModConfig instance;

    public static ModConfig get() {
        if (instance == null) load();
        return instance;
    }

    public static void load() {
        if (Files.exists(PATH)) {
            try (Reader reader = Files.newBufferedReader(PATH)) {
                instance = GSON.fromJson(reader, ModConfig.class);
            } catch (Exception e) {
                System.err.println("error ride: " + e);
            }
        }
        if (instance == null) instance = new ModConfig();
        save();
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(PATH)) {
            GSON.toJson(instance, writer);
        } catch (IOException e) {
            System.err.println("save error: " + e);
        }
    }
}
