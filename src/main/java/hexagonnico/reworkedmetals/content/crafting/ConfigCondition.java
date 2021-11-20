package hexagonnico.reworkedmetals.content.crafting;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.config.Config;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

/**
 * Allows to enable/disable recipes depending on config files.
 * 
 * @author Nico
 */
public class ConfigCondition implements ICondition {
    
    public static final Serializer SERIALIZER = new Serializer();
    
    private final ResourceLocation id;
    private final String condition;
    
    /**
     * Create condition
     * @param id ResourceLocation
     * @param config Config string value
     */
    private ConfigCondition(ResourceLocation id, String config) {
        this.id = id;
        this.condition = config;
    }
    
    @Override
    public ResourceLocation getID() {
        return this.id;
    }
    
    @Override
    public boolean test() {
        return Config.getBoolean(this.condition);
    }
    
    public static class Serializer implements IConditionSerializer<ConfigCondition> {
    
        private final ResourceLocation id = new ResourceLocation(ReworkedMetals.ID, "config");
        
        @Override
        public void write(JsonObject json, ConfigCondition value) {
            json.addProperty("config", value.condition);
        }
    
        @Override
        public ConfigCondition read(JsonObject json) {
            return new ConfigCondition(this.id, JSONUtils.getAsString(json, "config", ""));
        }
    
        @Override
        public ResourceLocation getID() {
            return this.id;
        }
    }
}
