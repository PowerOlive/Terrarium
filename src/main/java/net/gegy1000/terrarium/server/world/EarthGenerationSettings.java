package net.gegy1000.terrarium.server.world;

import com.google.gson.Gson;
import joptsimple.internal.Strings;
import net.gegy1000.terrarium.Terrarium;

public class EarthGenerationSettings {
    public static final double REAL_SCALE = 92.766203;

    private static final Gson GSON = new Gson();

    public double spawnLatitude = 27.988350;
    public double spawnLongitude = 86.923641;
    public boolean mapFeatures = true;
    public boolean buildings = true;
    public boolean streets = true;
    public boolean decorate = true;
    public double terrainHeightScale = 1.0;
    public double worldScale = 0.03;
    public int heightOffset = 5;
    public int scatterRange = 200;

    public static EarthGenerationSettings deserialize(String settings) {
        if (Strings.isNullOrEmpty(settings)) {
            return new EarthGenerationSettings();
        }
        try {
            return GSON.fromJson(settings, EarthGenerationSettings.class);
        } catch (Exception e) {
            Terrarium.LOGGER.error("Failed to parse settings string: \"{}\"", settings, e);
        }
        return new EarthGenerationSettings();
    }

    public double getFinalScale() {
        return this.worldScale * REAL_SCALE;
    }

    public double getInverseScale() {
        return 1.0 / this.getFinalScale();
    }

    public String serialize() {
        return GSON.toJson(this);
    }
}
