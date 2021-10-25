package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.block.SmelteryBlock;
import hexagon.reworkedmetals.container.SmelteryContainerMenu;
import hexagon.reworkedmetals.crafting.SmelteryRecipe;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SmelteryBlockEntity extends BaseContainerBlockEntity {
    
    protected int litTime;
    protected int cookTime;
    protected int totalCookTime;
    protected NonNullList<ItemStack> inventory;
    protected Component customName;
    
    public SmelteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMELTERY.get(), pos, state);
        this.inventory = NonNullList.withSize(6, ItemStack.EMPTY);
    }
    
    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.litTime = compoundTag.getInt("LitTime");
        this.cookTime = compoundTag.getInt("CookTime");
        this.totalCookTime = compoundTag.getInt("TotalCookTime");
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if(compoundTag.contains("CustomName")) this.customName = Component.Serializer.fromJson(compoundTag.getString("CustomName"));
        ContainerHelper.loadAllItems(compoundTag, this.inventory);
    }
    
    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        super.save(compoundTag);
        compoundTag.putInt("LitTime", this.litTime);
        compoundTag.putInt("CookTime", this.cookTime);
        compoundTag.putInt("TotalCookTime", this.totalCookTime);
        ContainerHelper.saveAllItems(compoundTag, this.inventory);
        if(this.customName != null) compoundTag.putString("CustomName", Component.Serializer.toJson(this.customName));
        return compoundTag;
    }
    
    @Override
    protected Component getDefaultName() {
        return new TextComponent("container.reworkedmetals.smeltery");
    }
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new SmelteryContainerMenu(id, playerInventory, this);
    }
    
    @Override
    public int getContainerSize() {
        return this.inventory.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.inventory.stream().allMatch(ItemStack::isEmpty);
    }
    
    @Override
    public ItemStack getItem(int index) {
        return this.inventory.get(index);
    }
    
    @Override
    public ItemStack removeItem(int index, int flags) {
        return ContainerHelper.removeItem(this.inventory, index, flags);
    }
    
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.inventory, index);
    }
    
    @Override
    public void setItem(int index, ItemStack item) {
        ItemStack itemStack = this.inventory.get(index);
        boolean flag = !item.isEmpty() && item.sameItem(itemStack) && ItemStack.tagMatches(item, itemStack);
        this.inventory.set(index, item);
        if(item.getCount() > this.getMaxStackSize()) {
            item.setCount(this.getMaxStackSize());
        }
        if(index == 0 && !flag) {
            // cooking time = ...
            this.setChanged();
        }
    }
    
    @Override
    public boolean stillValid(Player player) {
        if(this.level != null && this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double) this.worldPosition.getX() + 0.5, (double) this.worldPosition.getY() + 0.5, (double) this.worldPosition.getZ() + 0.5) <= 64.0;
        }
    }
    
    @Override
    public void clearContent() {
        this.inventory.clear();
    }
    
    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return new ClientboundBlockEntityDataPacket(this.worldPosition, 1, this.getUpdateTag());
    }
    
    @Override
    public CompoundTag getUpdateTag() {
        return this.save(new CompoundTag());
    }
    
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }
    
    public static void cookingTick(Level level, BlockPos pos, BlockState state, SmelteryBlockEntity smelteryBlockEntity) {
        ItemStack fuel = smelteryBlockEntity.inventory.get(4);
        Optional<SmelteryRecipe> recipe = level.getRecipeManager().getRecipeFor(SmelteryRecipe.TYPE, smelteryBlockEntity, level);
        if(recipe.isPresent() && isValidFuel(fuel) && recipe.get().matches(smelteryBlockEntity, level)) {
            System.out.println("Recipe is valid!");
            state.setValue(SmelteryBlock.LIT, true);
        } else {
            state.setValue(SmelteryBlock.LIT, false);
        }
    }
    
    private static boolean isValidFuel(ItemStack itemStack) {
        return !itemStack.isEmpty() && itemStack.getItem().equals(Items.COAL);
    }
}
