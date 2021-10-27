package hexagon.reworkedmetals.item;

import hexagon.reworkedmetals.registry.ModItems;

import java.util.function.Supplier;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

@MethodsReturnNonnullByDefault
public enum ModToolTiers implements Tier {
    COPPER(1, 190, 5.0f, 1.5f, 12, () -> Ingredient.of(Items.COPPER_INGOT)),
    BRONZE(2, 250, 6.0f, 2.0f, 15, () -> Ingredient.of(ModItems.BRONZE_INGOT.get())),
    IRON(2, 700, 7.0f, 2.5f, 12, () -> Ingredient.of(Items.IRON_INGOT)),
    STEEL(3, 1561, 8.0f, 3.0f, 10, () -> Ingredient.of(ModItems.STEEL_INGOT.get()));
    
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;
    
    ModToolTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }
    
    @Override
    public int getLevel() {
        return this.level;
    }
    
    @Override
    public int getUses() {
        return this.uses;
    }
    
    @Override
    public float getSpeed() {
        return this.speed;
    }
    
    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }
    
    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }
    
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
