package net.samu.mineloween.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.samu.mineloween.item.ModItems;
import net.samu.mineloween.recipe.GemstoneGrinderRecipe;
import net.samu.mineloween.screen.GemstoneGrinderScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GemstoneGrinderBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final Integer INPUT_SLOT = 0;
    private static final Integer OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public GemstoneGrinderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEMSTONE_GRINDER_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 ->  GemstoneGrinderBlockEntity.this.progress;
                    case 1 ->  GemstoneGrinderBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: GemstoneGrinderBlockEntity.this.progress = value;
                    case 1: GemstoneGrinderBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Gemstone Grinder");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GemstoneGrinderScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("gemstone_grinder.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        progress = nbt.getInt("gemstone_grinder.progress");
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos blockPos, BlockState blockState) {
        if (canInsertIntoOutputSlot() && hasRecipe()) {
            increaseCraftingProgress();
            markDirty(world, blockPos, blockState);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount() - 1; // servono almeno 2 slot liberi
    }

    private boolean hasRecipe() {
        Optional<GemstoneGrinderRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) return false;

        ItemStack output = recipe.get().getOutput(null);

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<GemstoneGrinderRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(GemstoneGrinderRecipe.Type.INSTANCE, inventory, this.getWorld());
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void craftItem() {
        Optional<GemstoneGrinderRecipe> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + recipe.get().getOutput(null).getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
