package net.xiaoyu233.fml.reload.mixins.fix;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

import static net.xiaoyu233.fml.util.ReflectHelper.dyCast;

@Mixin(BlockAnvil.class)
public abstract class FixAnvilStackCrash extends BlockFalling {
    public FixAnvilStackCrash(int par1, Material material, BlockConstants constants) {
        super(par1, material, constants);
    }

    @Override
    public boolean canFallDownTo(World world, int x, int y, int z, int metadata) {
        Block block_below = world.getBlock(x, y, z);
        int block_below_metadata = world.getBlockMetadata(x, y, z);
        return (block_below == null || !block_below.isSolid(block_below_metadata) || EntityFallingSand.canDislodgeOrCrushBlockAt(world, dyCast(this), metadata, x, y, z)) && !(world.getBlock(x, y, z) instanceof BlockLadder);
    }
}
