package hexagonnico.reworkedmetals.content.crafting;

import com.google.gson.JsonObject;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.config.Config;

import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigCondition implements ICondition {
    
    public static final Serializer SERIALIZER = new Serializer();
    
    private final ResourceLocation id;
    private final String condition;
    
    private ConfigCondition(ResourceLocation id, String condition) {
        this.id = id;
        this.condition = condition;
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
