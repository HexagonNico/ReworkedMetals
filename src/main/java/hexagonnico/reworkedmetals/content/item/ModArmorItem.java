package hexagonnico.reworkedmetals.content.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Armor item override need to apply custom attributes.
 * @author Nico
 */
public class ModArmorItem extends ArmorItem {

	private final Multimap<Attribute, AttributeModifier> attributeModifiers;
	private final boolean piglinsNeutral;

	/**
	 * Puts custom attributes in map
	 * @param material ModArmorMaterials
	 * @param slot EquipmentSlot
	 * @param properties Item.Properties
	 */
	public ModArmorItem(ModArmorMaterials material, EquipmentSlot slot, Item.Properties properties) {
		super(material, slot, properties);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(super.getDefaultAttributeModifiers(slot));
		builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier("Movement speed", material.getSpeedModifier(), AttributeModifier.Operation.MULTIPLY_BASE));
		this.attributeModifiers = builder.build();
		this.piglinsNeutral = material.isGold();
	}

	@Override // Applies attribute modifiers
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		return slot == this.slot ? this.attributeModifiers : super.getDefaultAttributeModifiers(slot);
	}

	@Override // If this is a gold armor
	public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
		return this.piglinsNeutral;
	}
}
