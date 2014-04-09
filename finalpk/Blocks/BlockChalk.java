package org.finalpk.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import org.finalpk.TileEntities.TileEntityChalk;
import org.finalpk.common.ServerProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChalk extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150182_M;
    @SideOnly(Side.CLIENT)
    private IIcon field_150183_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_150184_O;
    @SideOnly(Side.CLIENT)
    private IIcon field_150180_P;

    public BlockChalk()
    {
        super(Material.circuits);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 5;
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return 8388608;
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) || p_149742_1_.getBlock(p_149742_2_, p_149742_3_ - 1, p_149742_4_) == Blocks.glowstone;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);

        if (l > 0)
        {
            double d0 = (double)p_149734_2_ + 0.5D + ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            double d1 = (double)((float)p_149734_3_ + 0.0625F);
            double d2 = (double)p_149734_4_ + 0.5D + ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
            float f = (float)l / 15.0F;
            float f1 = f * 0.6F + 0.4F;

            if (l == 0)
            {
                f1 = 0.0F;
            }

            float f2 = f * f * 0.7F - 0.5F;
            float f3 = f * f * 0.6F - 0.7F;

            if (f2 < 0.0F)
            {
                f2 = 0.0F;
            }

            if (f3 < 0.0F)
            {
                f3 = 0.0F;
            }

            p_149734_1_.spawnParticle("reddust", d0, d1, d2, (double)f1, (double)f2, (double)f3);
        }
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return ServerProxy.itemChalk;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_150182_M = p_149651_1_.registerIcon(this.getTextureName() + "_" + "cross");
        this.field_150183_N = p_149651_1_.registerIcon(this.getTextureName() + "_" + "line");
        this.field_150184_O = p_149651_1_.registerIcon(this.getTextureName() + "_" + "cross_overlay");
        this.field_150180_P = p_149651_1_.registerIcon(this.getTextureName() + "_" + "line_overlay");
        this.blockIcon = this.field_150182_M;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getRedstoneWireIcon(String p_150173_0_)
    {
        return p_150173_0_.equals("cross") ? this.field_150182_M : (p_150173_0_.equals("line") ? this.field_150183_N : (p_150173_0_.equals("cross_overlay") ? this.field_150184_O : (p_150173_0_.equals("line_overlay") ? this.field_150180_P : null)));
    }
    
    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityChalk(world);
    }
}
